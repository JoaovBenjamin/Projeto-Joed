# Projeto Joed

API Rest do projeto Joed - Gestor de Lojas

## Requisitos

- [ ] CRUD de Categorias
- [ ] CRUD de Produtos
- [ ] CRUD de Usuarios
- [ ] Autenticação
- [ ] Dashboard
- [ ] CRUD de Estoque

## Documentação

### Endpoints

- [Listar Categorias](#listar-categorias)
- [Cadastrar Categorias](#cadastrar-categorias)
- [Apagar Categorias](#apagar-categoria)
- [Detalhar Categorias](#detalhar-categoria)
- [Atualizar Categorias](#atualizar-categoria)
- [Listar Produtos](#listar-produtos)
- [Cadastrar Produto](#cadastrar-produto)
- [Apagar  Produto](#apagar-produto)
- [Detalhar Produto](#detalhar-produto)
- [Atualizar Produto](#atualizar-produto)
- [Listar Usuarios](#listar-usuarios)
- [Cadastrar Usuario](#cadastrar-usuario)
- [Apagar  Usuario](#apagar-usuario)
- [Detalhar  Usuario](#detalhar-usuario)
- [Atualizar  Usuario](#atualizar-usuario)
- [Listar Estoque](#listar-estoque)
- [Lançar Estoque](#lancar-estoque)
- [Deletar Estoque](#deletar-estoque)
- [Detalhar Estoque](#detalhar-estoque)

### Listar Categorias

`GET` /categorias

Retorna um array com todas as categorias cadastradas pelo usuario atual.

### Exemplo de Resposta

```js
    [
        {
            "id": "1",
            "nome": "Utensílios de Cozinha ",
            "icone": "Cozinha"
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
        "nome": "Utensílios de Cozinha ",
        "icone": "cozinha"
    }
```
### Exemplo de Resposta

```js
{
    "id": "2",
    "nome": "Cama,mesa e Banho",
    "icone": "Toalha de Mesa"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|201| Categorias cadastrada com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição
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
|404| A categoria não foi encontrada, Verifique o `id` informado	
---

### Detalhar categoria

`GET` /categoria/`{id}`

Retorna os dados da categoria com o `id` informado no parametro do path

### Exemplo de Resposta

```js

{
    "id": "2",
    "nome": "Cama, mesa e banho",
    "icone": "Toalha de Mesa"
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
        "nome": "Cama, mesa e Banho",
        "icone": "Toalha de Mesa"
    }
```
### Exemplo de Resposta

```js
{
    "id": "2",
    "nome": "Cama, mesa e banho",
    "icone": "Toalha de Mesa"
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

### Listar Produtos

`GET` /categoria/produtos

Retorna um array com todas os produtos cadastradas em determinda categoria pelo usuario atual.

### Exemplo de Resposta

```js
    [
        {
            "id": "1",
            "nome": "Escorredor de Bambu",
            "icone": "Escorredor de Bambu"
        }
    ]
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Categorias retornadas com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login

---

### Cadastrar Produto

`POST` /produto

Cadastra um produto em uma categoria criada pelo usuario atual de acordo com os dados enviados no corpo da requisição.

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| um nome curto para indentificar o produto|
|icone|string|✅ |O nome do icone conforme biblioteca Material Icons
|categoria|ObjectId|✅| Id de uma categoria, caso o Id não exista, irá ser criado uma  nova categoria com esse Id.
|descrição|string|❌| Uma breve descrição do que é esse produto|

```js
    {
        "nome": "Escorredor de Bambu",
        "icone": "Escorredor de Bambu",
        "categoriaId": "1",
        "descricao": "descrição do produto"
    }
```
### Exemplo de Resposta

```js
{
    "id": "1",
    "nome": "Escorredor de Bambu",
    "icone": "Escorredor de Bambu",
    "descricao": "descricao do produto",
    "categoriaId": "1"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|201| Produto cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login
---

### Apagar Produto

`DELETE` /produto/`{id}`

Apaga o produto com o `id` informado no parametro do path

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Produto apagado com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login
|404| O produto não foi encontrada, Verifique o `id` informado	
---

### Detalhar Produto

`GET` /produto/`{id}`

Retorna os dados do produto com o `id` informado no parametro do path

### Exemplo de Resposta

```js

{
    "id": "1",
    "nome": "Escorredor de Bambu",
    "icone": "Escorredor de Bambu",
    "descricao": "descricao do produto",
    "categoria": "Utensílios de Cozinha"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Produto retornado com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login
|404| Não existe produto com o `id` informado
---

### Atualizar Produto

`PUT` /produto/`{id}`

Atualiza os dados do produto com o `id` informado no path

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| um nome curto para indentificar o produto|
|icone|string|✅ |O nome do icone conforme biblioteca Material Icons
|categoria|ObjectId|✅| Id de uma categoria, caso o Id não exista, irá ser criado uma  nova categoria com esse Id.
|descrição|string|❌| Uma breve descrição do que é esse produto|

```js
    {
        "nome": "Escorredor de Bambu",
        "icone": "Escorredor de Bambu",
        "categoriaId": "1",
        "descricao": "descrição do produto"
    }
```
### Exemplo de Resposta

```js
{
    "id": "1",
    "nome": "Escorredor de Bambu",
    "icone": "Escorredor de Bambu",
    "descricao": "descricao do produto",
    "categoriaId": "1"
}
```
### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Produto cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login
|404| Não existe produto com o `id` informado
---

### Listar Usuarios

`GET` /usuarios

Retorna um array com todos os usuarios cadastrados no seu sistema.

### Exemplo de Resposta

```js
    [
        {
            "id": "1",
            "nome": "Usuario 1",
        }
    ]
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Usuarios retornadas com sucesso
---

### Cadastrar Produto

`POST` /usuario

Cadastra um usuario com os dados enviados no corpo da requisição.

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| nome  do usuario |
|senha|string|✅| senha |   
|e-mail|string|✅| e-mail do usuario |

```js
    {
       "id": "1",
       "nome":"User Example",
       "senha":"123456",
       "email":"user@example.com"
    }
```
### Exemplo de Resposta

```js
{
       "id" : "1",
       "nome":"User Example",
       "senha":"123456",
       "email":"user@example.com"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|201| Usuario cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição

---

### Apagar Usuario

`DELETE` /usuario/`{id}`

Apaga o usuario com o `id` informado no parametro do path

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Usuario apagado com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login
|404| O Usuario não foi encontrada, Verifique o `id` informado	
---

### Detalhar Usuario

`GET` /usuario/`{id}`

Retorna os dados do Usuario com o `id` informado no parametro do path

### Exemplo de Resposta

```js

{
    "id": "1",
    "nome": "Exemplo",
    "email": "ex@ex.com",
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Usuario retornado com sucesso
|404| Não existe usuario com o `id` informado
---
### Atualizar Usuario

`PUT` /usuario/`{id}`

Atualiza os dados do usuario com o `id` informado no path

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| nome  do usuario |
|senha|string|✅| senha |   
|e-mail|string|✅| e-mail do usuario |

```js
    {
       "id": "1",
       "nome":"User Example",
       "senha":"123456",
       "email":"user@example.com"
    }
```
### Exemplo de Resposta

```js
{
       "id" : "1",
       "nome":"User Example",
       "senha":"123456",
       "email":"user@example.com"
}
```
### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Usuario atualizado com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login
|404| Não existe usuario com o `id` informado
---

### Listar Estoque

`GET` /produto/estoque

Retorna um int  com a quantidade total de produtos no estoque

### Exemplo de Resposta

```js
    [
        {
            "id":"1",
            "estoque": "quantidade"
        }
    ]
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|200| Estoque retornadas com sucesso
|401| Não autorizado. Realize a autenticaçãoem /login

---

### Lançar Estoque

`POST` /produto/estoque

Lança a quantidade de um produto

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|Quantidade|int|✅|A quantidade do produto em estoque, que sera lançado.

```js
    {
        "id": "1",
        "Quantidade": "5"
    }
```
### Exemplo de Resposta

```js
{
        "id": "1",
        "Quantidade": "5"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|201| Estoque lançado com sucesso
|400| Validação falhou. Verifique os dados enviados da requisição
|401| Não autorizado. Realize a autenticaçãoem /login

---

### Deletar Estoque

`DELETE` /produto/estoque/`{id}`

Apaga o estoque do produto com o `id` informado no parametro do path

### Corpo de Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|Quantidade|int|✅|A quantidade do produto em estoque,  que será apagada do estoque atual. 

```js
    {
        "id": "1",
        "Quantidade": "5"
    }
```
### Exemplo de Resposta

```js
{
        "id": "1",
        "Quantidade": "5"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Estoque apago com sucesso
|401| Não autorizado. Realize a autenticação em /login
|400| Validação falhou. Verifique os dados enviados da requisição
|404| O produto não foi encontrada, Verifique o `id` informado	
---

### Detalhar Estoque

`GET` /produto/estoque/`{id}`

Retorna os dados do estoque com o `id` informado no parametro do path

### Exemplo de Resposta

```js

{
    "id": "1",
    "quantidade":"5"
}
```

### Códigos de Resposta

| Código | descrição |
|--------|-----------|
|204| Estoque retornado com sucesso
|404| Não existe estoque com o `id` informado
---