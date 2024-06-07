
## TodoList

Back-end para a atividade de criação de uma "Lista de Tarefas".

## Documentação da API

## **Membro**

#### Retorna o membro criado

```http
  POST /api/membro/
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | **Obrigatório**. Nome do membro |
| `email` | `string` | **Obrigatório**. email do membro |

#### Retorna um item

```http
  GET /api/membro/login?email=
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. Email do membro cadastrado |

## **Tarefa**

#### Retorna todas tarefas criadas

```http
  GET /api/tarefa/
```

#### Retorna a nova tarefa criada

```http
  POST /api/tarefa/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. Id de quem cria a tarefa |

#### Retorna a tarefa atualizada

```http
  PUT /api/tarefa/alterar/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. Id da tarefa |

#### Retorna a tarefa deletada

```http
  DELETE /api/tarefa/deletar/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. Id da tarefa |

#### Retorna a tarefa com o atributo `dataTermino` e `Finalizada` modificados

```http
  PUT /api/tarefa/finalizar/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. Id da tarefa |


