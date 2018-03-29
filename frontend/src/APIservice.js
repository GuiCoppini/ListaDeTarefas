import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api'
});

export function getListas() {
  return api.get('/listadetarefas/')
    .then(results => {
      return results.data;
    })
}

export function getLista(id) {
  return api.get('/listadetarefas/'+id)
    .then(results => {
      return results.data;
    })
}

export function getTarefa(id) {
  return api.get('/tarefas/'+id)
    .then(results => {
      console.log(results)
      return results.data;
    })
}

export function postLista(lista) {
    api.post('/listadetarefas/new',
      lista
    ).then(function (response) {
      console.log(response);
    }).catch(function (error) {
      console.log(error);
    })
}

export function postTarefa(taskListId, tarefa) {
    console.log(JSON.stringify(tarefa))
    api.post(`/listadetarefas/${taskListId}/new`,
      tarefa
    ).then(function (response) {
      console.log(response);
    }).catch(function (error) {
      console.log(error);
    })
}

