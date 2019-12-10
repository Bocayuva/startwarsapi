# startwarsapi

Desafio Star Wars para B2W, Criar uma API de Planetas, com as seguintes funcionalidades. 

- Adicionar um planeta (com nome, clima e terreno)  
- Listar planetas  
- Buscar por nome  
- Buscar por ID  
- Remover planeta

Desenvolvimento de uma API, usando:

- JAVA
- MAVEN
- SPRING BOOT
- USO DA API EXTERNA https://swapi.co/

Teste da api usar o arquivo postman: Starwars.postman_collection.json

-----------------------------------------------------------
                   Documentação da API                
-----------------------------------------------------------

-----------------------------------------------------------
-----           BUSCAR TODOS OS PLANETAS              -----

GET http://localhost:8081/planets/


-----------------------------------------------------------
-----        BUSCAR UM PLANETA PELO ID                -----

GET http://localhost:8081/planets/PLANETID

  PLANETID é o id do planeta no banco


-----------------------------------------------------------
-----        BUSCAR UM PLANETA PELO NOME              -----

GET http://localhost:8081/planets/name/PLANETNAME

  PLANETNAME é nome do planeta salvo no banco


-----------------------------------------------------------
-----               CRIAR UM PLANETA                  -----

POST http://localhost:8081/planets/

  Exemplo de body:
  {
	  "name": "Yavin IV",
	  "climate": "tropical",
	  "terrain": "jungle"
  }
  
  Atributos:
    name é nome do planeta
    climate é clima do planeta
    terrain é terreno do planeta

  CODE - RESPOSTA
  200 - salvou com sucesso
  500 - falhou a requisição


-----------------------------------------------------------
-----               ATUALIZAR UM PLANETA              -----

PUT http://localhost:8081/planets/

  Exemplo de body:
  {
      "name": "Alderaan",
      "climate": "temperate",
      "terrain": "grasslands2",
  }
  
  Atributos:
    name é nome do planeta
    climate é clima do planeta
    terrain é terreno do planeta
  
  CODE - RESPOSTA
  200 - salvou com sucesso
  500 - falhou a requisição


-----------------------------------------------------------
-----               DELETAR UM PLANETA                -----

DELETE http://localhost:8081/planets/PLANETID

  PLANETID é id do planeta no banco
  
  CODE - RESPOSTA
  200 - deletou com sucesso
  500 - falhou a requisição
