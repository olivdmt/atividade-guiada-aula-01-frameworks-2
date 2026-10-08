# Atividade Guiada: API CRUD para Controle de Tarefas com Spring Boot

Repositório da atividade guiada de desenvolvimento de uma API CRUD para controle de tarefas utilizando Spring Boot.

## 📌 Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4.1.1**
- **Spring Web**
- **Maven**

## 📁 Estrutura do Projeto

```
com.example.task_api
├── controller
│   └── TaskController.java
├── modle
│   └── Task.java
├── repository
│   └── TaskRepository.java
└── TaskApiApplication.java
```

## 🚀 Endpoints da API

A API expõe as seguintes rotas sob o recurso `/tasks`:

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/tasks` | Retorna a lista de todas as tarefas cadastradas |
| `GET` | `/tasks/{id}` | Retorna os detalhes de uma tarefa com ID específico |
| `POST` | `/tasks` | Cria uma nova tarefa |
| `PUT` | `/tasks/{id}` | Atualiza uma tarefa existente pelo ID |
| `DELETE` | `/tasks/{id}` | Exclui uma tarefa com o ID especificado |

---

### Exemplos de Requisições

#### 1. Criar Tarefa (POST `/tasks`)
**Body (JSON):**
```json
{
  "id": 1,
  "title": "Casa",
  "description": "Organizar as tarefas de casa",
  "dueDate": "2026-12-31T00:00:00"
}
```

#### 2. Listar Todas as Tarefas (GET `/tasks`)
Retorna uma lista contendo todas as tarefas armazenadas em memória.

#### 3. Buscar Tarefa por ID (GET `/tasks/{id}`)
Retorna o objeto correspondente à tarefa com o ID informado.

#### 4. Atualizar Tarefa (PUT `/tasks/{id}`)
**Body (JSON):**
```json
{
  "id": 1,
  "title": "trabalho",
  "description": "Organizar as tarefas do trabalho",
  "dueDate": "2026-12-25T10:00:00"
}
```

#### 5. Excluir Tarefa (DELETE `/tasks/{id}`)
Remove a tarefa indicada pelo ID.

---

## 💻 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/olivdmt/atividade-guiada-aula-01-frameworks-2
cd atividade-guiada-aula-01-frameworks-2
```

2. Execute o projeto usando o Maven Wrapper:
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux / Mac
./mvnw spring-boot:run
```

3. A aplicação estará disponível em `http://localhost:8080`.
