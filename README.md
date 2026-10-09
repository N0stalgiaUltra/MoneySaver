> 🇧🇷 Português | [🇺🇸 English](README.en.md)

# MoneySaver

Aplicativo Android de controle de gastos pessoais, usado como **laboratório de TDD e arquitetura modular**.

[![CI](https://github.com/N0stalgiaUltra/MoneySaver/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/N0stalgiaUltra/MoneySaver/actions/workflows/main.yml)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

## Por que este projeto existe

Este não é um app de produção — é um ambiente controlado para praticar duas coisas que raramente aparecem juntas em projeto de estudo: **desenvolvimento guiado por testes** e **separação real de camadas em módulos Gradle independentes**.

O domínio escolhido (controle de despesas) é simples o bastante para não roubar atenção da arquitetura, e complexo o bastante para ter regra de negócio de verdade: validação de valores, categorização, mapeamento entre entidade de persistência e modelo de domínio.

## Escopo atual

O desenvolvimento segue **de dentro para fora**: a lógica de cadastro foi construída e coberta por testes antes da camada de apresentação.

**Implementado:**
- Módulos `domain`, `database` e `app` separados, com dependências unidirecionais
- Persistência local com Room
- Mapeamento entre entidades de dados e modelos de domínio, coberto por testes unitários
- Fluxo de cadastro de transação
- Injeção de dependência com Koin
- Pipeline de CI com lint, testes unitários e testes instrumentados

**Ainda não implementado (deliberadamente):**
- Exibição da lista de transações na UI — a tela de cadastro existe, mas o item adicionado ainda não é renderizado
- Edição e exclusão de transações
- Dashboard de estatísticas
- Metas de orçamento e notificações

O planejamento completo está em [`CASOSDEUSO.md`](CASOSDEUSO.md) (casos de uso detalhados) e [`objetivo.md`](objetivo.md) (metas técnicas). Esses arquivos descrevem o destino do projeto, não o estado atual.

## Arquitetura

```
┌─────────────┐
│     app     │  UI (Fragments + XML), ViewModels, Koin
└──────┬──────┘
       │
┌──────▼──────┐
│   domain    │  Modelos de domínio, regras de negócio, mappers
└──────▲──────┘
       │
┌──────┴──────┐
│  database   │  Room, DAOs, entidades, data sources
└─────────────┘
```

O módulo `domain` não conhece Android nem Room — é Kotlin puro, o que permite testá-lo com JUnit sem emulador. Essa é a decisão central do projeto: tudo que é regra de negócio precisa ser testável em milissegundos.

## Testes

**49 testes no total — 30 unitários e 19 instrumentados.**

| Tipo | Onde | Executa com |
|---|---|---|
| Unitários | `domain`, `app` | `./gradlew test` |
| Instrumentados | `database` (DAOs e data sources) | `./gradlew connectedCheck` |

Os testes de persistência são instrumentados por necessidade: validar DAO do Room exige um device real ou emulador. Já as regras de domínio e os mappers rodam na JVM, sem device.

```bash
# Testes unitários de todos os módulos
./gradlew test

# Testes instrumentados (requer emulador ou device conectado)
./gradlew connectedCheck

# Lint
./gradlew lintDebug
```

Os relatórios HTML de cada módulo ficam em `<módulo>/build/reports/tests/`.

## Integração contínua

O pipeline ([`.github/workflows/main.yml`](.github/workflows/main.yml)) roda em três estágios encadeados:

1. **lint** — análise estática
2. **unit-test** — testes unitários de todos os módulos, com relatório por módulo publicado como artefato
3. **instrumentation-test** — testes instrumentados em emulador (API 29)

Lint e testes unitários rodam em todo push e pull request. Os testes instrumentados rodam apenas na `main` e por disparo manual (`workflow_dispatch`), por causa do custo de subir emulador — um padrão comum para manter o feedback do dia a dia rápido sem abrir mão da cobertura.

Os relatórios de teste são publicados como artefatos mesmo quando a execução falha.

## Stack

| Camada | Tecnologias |
|---|---|
| Linguagem | Kotlin |
| UI | XML, Fragments, Material Design |
| Persistência | Room (kapt) |
| Injeção de dependência | Koin |
| Testes | JUnit, AndroidX Test |
| Build | Gradle 8.6 |
| CI | GitHub Actions |

## Como rodar

```bash
git clone https://github.com/N0stalgiaUltra/MoneySaver.git
cd MoneySaver
./gradlew assembleDebug
```

Requer JDK 17.

## Licença

Apache 2.0 — ver [LICENSE](LICENSE).