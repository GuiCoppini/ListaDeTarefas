import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080'
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
    alert('A name was submitted: ' + JSON.stringify(lista));
    fetch('http://localhost:8080/listadetarefas/new', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(lista)
    })
}
