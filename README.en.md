> [🇧🇷 Português](README.md) | 🇺🇸 English

# MoneySaver

Android personal expense tracker, built as a **TDD and modular architecture lab**.

[![CI](https://github.com/N0stalgiaUltra/MoneySaver/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/N0stalgiaUltra/MoneySaver/actions/workflows/main.yml)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

## Why this project exists

This is not a production app — it's a controlled environment for practicing two things that rarely show up together in a study project: **test-driven development** and **real layer separation across independent Gradle modules**.

The chosen domain (expense tracking) is simple enough not to steal attention from the architecture, and complex enough to have actual business rules: amount validation, categorization, and mapping between persistence entities and domain models.

## Current scope

Development goes **inside out**: the registration logic was built and covered by tests before the presentation layer.

**Implemented:**
- Separate `domain`, `database` and `app` modules, with one-way dependencies
- Local persistence with Room
- Mapping between data entities and domain models, covered by unit tests
- Transaction registration flow
- Dependency injection with Koin
- CI pipeline with lint, unit tests and instrumented tests

**Not implemented yet (by design):**
- Transaction list rendering — the registration screen exists, but the added item isn't displayed yet
- Editing and deleting transactions
- Statistics dashboard
- Budget goals and notifications

The full plan lives in [`CASOSDEUSO.md`](CASOSDEUSO.md) (detailed use cases) and [`objetivo.md`](objetivo.md) (technical goals). Those files describe where the project is headed, not its current state.

## Architecture

```
┌─────────────┐
│     app     │  UI (Fragments + XML), ViewModels, Koin
└──────┬──────┘
       │
┌──────▼──────┐
│   domain    │  Domain models, business rules, mappers
└──────▲──────┘
       │
┌──────┴──────┐
│  database   │  Room, DAOs, entities, data sources
└─────────────┘
```

The `domain` module knows nothing about Android or Room — it's pure Kotlin, which makes it testable with JUnit without an emulator. That's the central decision here: anything that is a business rule must be testable in milliseconds.

## Tests

**49 tests total — 30 unit and 19 instrumented.**

| Type | Where | Run with |
|---|---|---|
| Unit | `domain`, `app` | `./gradlew test` |
| Instrumented | `database` (DAOs and data sources) | `./gradlew connectedCheck` |

Persistence tests are instrumented out of necessity: validating a Room DAO requires a real device or emulator. Domain rules and mappers, on the other hand, run on the JVM with no device involved.

```bash
# Unit tests across all modules
./gradlew test

# Instrumented tests (requires a connected emulator or device)
./gradlew connectedCheck

# Lint
./gradlew lintDebug
```

HTML reports for each module land in `<module>/build/reports/tests/`.

## Continuous integration

The pipeline ([`.github/workflows/main.yml`](.github/workflows/main.yml)) runs in three chained stages:

1. **lint** — static analysis
2. **unit-test** — unit tests across all modules, with a per-module report published as an artifact
3. **instrumentation-test** — instrumented tests on an emulator (API 29)

Lint and unit tests run on every push and pull request. Instrumented tests run only on `main` and via manual dispatch (`workflow_dispatch`), given the cost of booting an emulator — a common pattern for keeping day-to-day feedback fast without giving up coverage.

Test reports are published as artifacts even when the run fails.

## Stack

| Layer | Technologies |
|---|---|
| Language | Kotlin |
| UI | XML, Fragments, Material Design |
| Persistence | Room (kapt) |
| Dependency injection | Koin |
| Testing | JUnit, AndroidX Test |
| Build | Gradle 8.6 |
| CI | GitHub Actions |

## Running it

```bash
git clone https://github.com/N0stalgiaUltra/MoneySaver.git
cd MoneySaver
./gradlew assembleDebug
```

Requires JDK 17.

## License

Apache 2.0 — see [LICENSE](LICENSE).