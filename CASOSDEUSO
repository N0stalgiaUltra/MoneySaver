# Controle de Gastos Pessoais - Casos de Uso

## 1. Registrar Nova Transação

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- O usuário deve estar autenticado (se aplicável).  
- A aplicação deve estar conectada (mesmo que o registro possa ser feito offline para sincronização posterior).

**Gatilho:**  
- O usuário decide registrar uma nova transação (despesa ou receita).

**Fluxo Principal (Cenário de Sucesso):**  
1. O usuário acessa a tela de "Nova Transação" via botão ou menu.  
2. O sistema apresenta um formulário com os seguintes campos obrigatórios:
   - Valor
   - Tipo (Despesa ou Receita)
   - Categoria
   - Data da transação
   - Descrição (opcional ou obrigatório, conforme a regra definida)
   - Método de pagamento (opcional)
3. O usuário preenche os campos e confirma o registro.
4. O sistema valida os dados:
   - Se os dados estiverem corretos, prossegue para salvar.
   - Caso contrário, exibe mensagens de erro para os campos inválidos.
5. O sistema salva a transação no banco de dados local (utilizando Room).  
6. Se houver integração com uma API remota, o sistema tenta sincronizar a transação; caso contrário, agenda a sincronização para um momento oportuno.
7. O sistema exibe uma mensagem de sucesso e atualiza a lista de transações.

**Fluxos Alternativos:**  
- **A1 – Dados Inválidos:**  
  1. Se algum campo obrigatório estiver vazio ou com formato incorreto, o sistema exibe mensagens de erro específicas.  
  2. O usuário corrige os dados e repete o envio.

- **A2 – Falha na Sincronização:**  
  1. Se a sincronização com a API remota falhar (ex.: falta de conexão), o sistema salva a transação localmente e agenda nova tentativa.  
  2. O usuário é informado sobre a situação e que a sincronização ocorrerá automaticamente quando possível.

**Pós-condições:**  
- A transação é registrada no banco de dados local e, se possível, sincronizada com o servidor remoto.  
- A nova transação passa a ser exibida na listagem e refletida nos dashboards estatísticos.

---

## 2. Visualizar Lista de Transações

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- O usuário deve estar autenticado (se aplicável).  
- Pelo menos uma transação deve estar registrada.

**Gatilho:**  
- O usuário acessa a tela principal do aplicativo.

**Fluxo Principal:**  
1. O sistema carrega as transações do banco de dados local.  
2. O sistema exibe uma lista resumida de transações (valor, data, categoria, tipo).  
3. O usuário pode:
   - Rolar a lista para visualizar mais registros.
   - Aplicar filtros por data, categoria ou tipo.
   - Selecionar uma transação para ver detalhes.

**Fluxos Alternativos:**  
- **A1 – Lista Vazia:**  
  - Se não houver transações registradas, o sistema exibe uma mensagem informando a ausência de registros e sugere a criação de uma nova transação.

**Pós-condições:**  
- O usuário visualiza e interage com a lista de transações.

---

## 3. Editar Transação

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- A transação a ser editada deve estar previamente registrada.

**Gatilho:**  
- O usuário seleciona uma transação existente e opta por editá-la.

**Fluxo Principal:**  
1. O usuário acessa a tela de detalhes da transação e seleciona a opção "Editar".  
2. O sistema exibe um formulário pré-preenchido com os dados atuais.  
3. O usuário realiza as alterações desejadas e confirma.  
4. O sistema valida os dados atualizados:
   - Se corretos, atualiza a transação.
   - Se houver erro, exibe mensagens e solicita correção.
5. O sistema atualiza o registro no banco de dados local e, se aplicável, sincroniza com a API remota.
6. O sistema exibe uma mensagem de sucesso e atualiza as informações na listagem e dashboards.

**Fluxos Alternativos:**  
- **A1 – Cancelamento da Edição:**  
  - Se o usuário cancelar, o sistema descarta as alterações e retorna à tela anterior sem modificar os dados.

**Pós-condições:**  
- A transação é atualizada conforme as alterações efetuadas.

---

## 4. Excluir Transação

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- A transação a ser excluída deve estar registrada.

**Gatilho:**  
- O usuário decide remover uma transação.

**Fluxo Principal:**  
1. O usuário seleciona a opção de excluir (ex.: ícone de lixeira ou menu contextual).  
2. O sistema solicita a confirmação da exclusão para evitar remoções acidentais.  
3. O usuário confirma a exclusão.  
4. O sistema remove a transação do banco de dados local e, se necessário, sincroniza a exclusão com a API remota.  
5. O sistema atualiza a lista de transações e exibe uma mensagem de confirmação.

**Fluxos Alternativos:**  
- **A1 – Cancelamento da Exclusão:**  
  - Se o usuário cancelar, o sistema retorna sem fazer alterações.

**Pós-condições:**  
- A transação é removida definitivamente do sistema.

---

## 5. Visualizar Dashboard de Estatísticas

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- Deve haver transações registradas para gerar as estatísticas.

**Gatilho:**  
- O usuário acessa a tela de Dashboard ou Estatísticas.

**Fluxo Principal:**  
1. O sistema coleta dados do banco de dados local.  
2. O sistema processa e agrega os dados para gerar estatísticas, tais como:
   - Distribuição de gastos por categoria (gráfico de pizza ou barras).
   - Resumos diários, semanais e mensais de despesas e receitas (gráfico de linhas ou barras).
3. O sistema exibe os gráficos e resumos em uma interface interativa.
4. O usuário pode interagir com os gráficos para visualizar detalhes ou filtrar por período.

**Pós-condições:**  
- O usuário visualiza um panorama financeiro que auxilia na tomada de decisões.

---

## 6. Definir e Acompanhar Metas de Orçamento

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- O usuário deve ter acesso à funcionalidade de metas (exibida na área de configurações ou logo após autenticação).

**Gatilho:**  
- O usuário decide definir ou ajustar o orçamento mensal.

**Fluxo Principal:**  
1. O usuário acessa a tela "Metas e Orçamento".  
2. O sistema exibe o orçamento atual e as metas definidas (se houver).  
3. O usuário insere ou altera o valor do orçamento.  
4. O sistema valida o valor e o salva no banco de dados.  
5. Com o registro de novas transações, o sistema calcula o total gasto e compara com o orçamento definido.  
6. Se os gastos se aproximarem ou ultrapassarem o orçamento, o sistema envia alertas (visuais e/ou notificações).

**Fluxos Alternativos:**  
- **A1 – Valor Inválido:**  
  - Se o usuário inserir um valor não numérico ou negativo, o sistema exibe mensagem de erro solicitando a correção.

**Pós-condições:**  
- O orçamento é atualizado e o acompanhamento dos gastos é iniciado automaticamente.

---

## 7. Configurar Lembretes e Notificações

**Ator Principal:**  
- Usuário

**Pré-condições:**  
- O usuário deve estar autenticado e acessar a área de configurações do aplicativo.

**Gatilho:**  
- O usuário decide configurar ou ajustar lembretes e notificações.

**Fluxo Principal:**  
1. O usuário acessa a tela de configurações e seleciona "Notificações e Lembretes".  
2. O sistema apresenta opções de configuração, como:
   - Frequência dos lembretes (diários, semanais, etc.).
   - Horários preferenciais para notificações.
3. O usuário define as preferências e confirma.
4. O sistema salva as configurações e agenda as notificações usando **AlarmManager** ou **WorkManager**.
5. No horário agendado, o sistema dispara as notificações para lembrar o usuário de registrar transações.

**Fluxos Alternativos:**  
- **A1 – Falha no Agendamento:**  
  - Se ocorrer algum erro ao agendar, o sistema registra o erro e informa o usuário, solicitando nova tentativa.

**Pós-condições:**  
- As configurações são salvas e as notificações são agendadas conforme as preferências do usuário.
