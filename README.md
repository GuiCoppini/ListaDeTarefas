# ListaDeTarefas
#### Para rodar a API:
1) Vá para a root do projeto onde está o arquivo `build.gradle`;
2) Rode `./gradlew bootRun` no terminal;
3) A API estará rodando na URL `http://localhost:8080/`.

---

#### Para rodar o frontend (DEV):
1) Vá para a pasta `frontend`;
2) Rode `yarn start` ou `npm start`;
3) O frontend estará rodando na URL `http://localhost:3000/`.

---

#### Swagger-UI
Acesse `http://localhost:8080/swagger-ui.html` enquanto a API estiver rodando.

---

#### Para dar deploy do frontend e serví-lo estaticamente:
1) Rode um `yarn build` ou `npm run build` na pasta frontend;
2) Jogue tudo que tem dentro da pasta frontend/build/ pra dentro da src/main/resources/static/ do projeto;
3) Acesse localhost:8080 e as páginas serão servidas por lá.
