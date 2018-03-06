export function getListas() {
  return fetch('http://localhost:8080/listadetarefas/')
      .then(results => {
        return results.json();
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
