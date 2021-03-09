/**
 * @author Bruno Pinho
 */


function validar(){
	let nome = registrarContato.nome.value
	let fone = registrarContato.fone.value
	let email = registrarContato.email.value
	
	if(nome === ""){
		alert('Preencha o campo nome!')
		registrarContato.nome.focus()
		return false
	}
		if(fone === ""){
		alert('Preencha o campo fone!')
		registrarContato.fone.focus()
		return false
	}
		if(email === ""){
		alert('Preencha o campo email!')
		registrarContato.email.focus()
		return false
	}
	else{
		document.forms["registrarContato"].submit()
	}
}