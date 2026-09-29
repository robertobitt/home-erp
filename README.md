> 🚧 **Status do Projeto:** Em desenvolvimento ativo / Em expansão.

# 📦 HomeERP – Sistema de Gestão e Controle de Estoque

> Aplicação em Java orientada a objetos para simulação e controle de rotinas de estoque e regras de negócio corporativas, desenvolvida com foco em arquitetura em camadas, padrões de projeto e persistência de dados relacional.

## 📌 Sobre o Projeto
O **HomeERP** é um sistema de gerenciamento de estoque e processos concebido com um modelo de domínio flexível e escalável: foi planejado estruturalmente para operar desde o controle de insumos e compras domésticas até a gestão de estoque e movimentações de uma média empresa.

A aplicação foi concebida para atender desde a gestão simplificada de suprimentos domésticos (compras e insumos familiares) até o controle parametrizado de estoque e PCP de uma média empresa. Sua arquitetura desacoplada permite que o sistema expanda em complexidade — suportando novas entidades, múltiplos depósitos e integrações relacioanais robustas — sem comprometer a estabilidade do código principal.

## 🎯 Principais Funcionalidades
Gestão de Estoque & Produtos: Cadastro, atualização, consulta e controle de movimentação de itens.

Isolamento de Regras de Negócio: Validações rigorosas de estados, parâmetros operacionais e cálculo de rotinas de entrada/saída.

Persistência de Dados Segura: Manipulação de banco de dados relacional via SQL.

Tratamento de Exceções: Mapeamento e gestão robusta de erros de sistema e de usuário para garantir a estabilidade da aplicação.

## 🛠️ Arquitetura e Padrões de Projeto
A estrutura da aplicação segue o padrão de arquitetura em camadas para garantir testabilidade, facilidade de manutenção e escalabilidade:

Camada de Apresentação / Controle: Gerencia o fluxo de execução e a interação com as entradas de dados.

Camada de Domínio (Business/Service): Isola a lógica e as regras de negócio cruciais da aplicação.

Camada de Acesso a Dados (DAO):

Data Access Object (DAO): Padrão utilizado para abstrair e isolar todo o acesso ao banco de dados.

Inversão de Dependência (DIP): Uso de interfaces para desacoplar a camada de negócio da implementação concreta de persistência, facilitando a substituição da base de dados e a criação de testes unitários.

## 🧰 Tecnologias e Ferramentas Utilizadas
Linguagem: Java (JDK 17+)

Paradigma: Orientação a Objetos (POO)

Persistência de Dados: SQL / SQLite / PostgreSQL

Conectividade: JDBC (PreparedStatement para prevenção contra vulnerabilidades de SQL Injection)

Controle de Versão: Git e GitHub

📂 Estrutura do Projeto
```Plaintext
src/
 ├── model/         # Entidades do domínio (ex: Produto, Movimentacao)
 ├── dao/           # Interfaces e implementações concretas de acesso ao banco (DAO/DIP)
 │    ├── interfaces/
 │    └── impl/
 ├── service/       # Camada de serviços e regras de negócio
 ├── util/          # Classes utilitárias (conexão com DB, tratamento de logs)
 └── Main.java      # Ponto de entrada da aplicação
```

## 🚀 Como Executar o Projeto
### Pré-requisitos
Java Development Kit (JDK) 17 ou superior instalado.

IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code).

Git instalado na máquina.

### Passo a Passo
Clonar o repositório:

```bash
git clone https://github.com
```
Acessar a pasta do projeto:

```Bash
cd home-erp
```

Abrir e Executar na IDE:

Abra a pasta do projeto na sua IDE favorita.

Aguarde o carregamento das dependências/estruturas.

Execute a classe principal Main.java.

## 👨‍💻 Autor
Roberto Bittencourt de Valem

Desenvolvedor de Software | Back-End Java

💼 LinkedIn: linkedin.com/in/roberto-bittencourt

🐙 GitHub: github.com/robertobitt

✉️ E-mail: robertobbtt@gmail.com

## 📌 Status e Próximos Passos (Roadmap)

- [x] Arquitetura base em camadas (MVP/DAO) e interfaces
- [x] Mapeamento de entidades de domínio (Produto, Estoque)
- [x] Conexão e persistência via JDBC com SQLite
- [ ] Implementação de relatórios de movimentação em PDF/CSV
- [ ] Cobertura de testes unitários com JUnit
- [ ] Interface gráfica ou API REST para integração
