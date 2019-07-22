/**
 * Created by delonj on 25/05/2019.
 */



testIfElse("Jack");
testIfElse("May");
testIfElse("Anna");
testIfElse("Kate");


function testIfElse(name) {
    if (name == 'Jack')
        console.log("Привет, дружок " + name + "!");
    else if (name == 'May')
        console.log("Привет, дружок кот " + name + "!");
    else if (name.startsWith('A'))
        console.log("Классное имя " + name);
    else
        console.log("Откуда ты " + name + "?");

}


function testFactorial(a) {
    var x = 1;
    console.log("start");
    for (var i = 1; a >= i; i++) {
        console.log('(' + i + ') * (' + x + ')');
        x *= i;
    }
    return x;
}

function testWhile(a) {
    var x=0;
    var i = 1;
    while(i <= a){
        if(i%2==0) {
            i+=i;
        } console.log(i+ " - число нечетное")
    }
    return x;
}


function f(s, text){
    var t = new RegExp(s, "g");
    return text.match(t).toString();
}

