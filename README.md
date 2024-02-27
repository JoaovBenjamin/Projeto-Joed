# Projeto Joed

API Rest do projeto Joed - Gestor de Lojas

## Requisitos

- [ ] CRUD de Categorias
- [ ] CRUD de Movimentações
- [ ] CRUD de Usuarios
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Categorias](#listar-categorias)
- [Cadastrar Categorias](#cadastrar-categorias)
- [Apagar Categorias](#apagar-categoria)
- [Detalhar Categorias](#detalhar-categoria)
- [Atualizar Categorias](#atualizar-categoria)

### Listar Categorias

`GET` /categorias

Retorna um array com todas as categorias cadastradas pelo usuario atual.

### Exemplo de Resposta

```js
    [
        {
            "id": "1",
            "nome": "Alimentação",
            "icone": "fast-food"
        }
    ]
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Categorias retornadas com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login

---

### Cadastrar Categorias

`POST` /categorias

Cadastra uma categora com os dados enviados no corpo da requisição.

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| um nome curto para indentificar a categoria|
|icone|string|❌ |O nome do icone conforme biblioteca Material Icons

```js
    {
        "nome": "Alimentação",
        "icone": "fast-food"
    }
```
### Exemplo de Resposta

```js
{
    "id": "1",
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|201| Categorias cadastrada com sucesso
|400| Validação falhou. Verifiqye os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login

---

### Apagar Categoria

`DELETE` /categoria/`{id}`

Apaga a categoria com o `id` informado no parametro do path

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Categorias apagada com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login
---

### Detalhar categoria

`GET` /categoria/`{id}`

Retorna os dados da categoria com o `id` informado no parametro do path

### Exemplo de Resposta

```js
// requisição /categoria/1
{
    "id": "1",
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Categorias retornada com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login
|404| Não existe categoria com o `id` informado
---

### Atualizar Categoria

`PUT` /categoria/`{id}`

Atualiza os dados da categoria com o `id` informado no path

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| um nome curto para indentificar a categoria|
|icone|string|✅ |O nome do icone conforme biblioteca Material Icons

```js
    {
        "nome": "Alimentação",
        "icone": "fast-food"
    }
```
### Exemplo de Resposta

```js
{
    "id": "1",
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Categorias cadastrada com sucesso
|400| Validação falhou. Verifiqye os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login
|404| Não existe categoria com o `id` informado

---

