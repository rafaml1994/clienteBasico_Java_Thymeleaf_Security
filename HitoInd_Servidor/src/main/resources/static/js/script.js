const placeHolder = document.getElementsByTagName('input');

for (let input of placeHolder) {

    if (input.type == 'text' || input.type == 'password'){
        input.addEventListener('click',()=>{
            input.placeholder="";
        })
    }
}