
data class No(val head:Int, val tail:No?)

val l1 = No(1,No(2,No(1,No(3,No(5,No(2,No(3,No(2,null))))))))
val l2 = No(1,No(2,No(3,No(5,null))))
//Calcular o número de elementos da lista

fun tamanho(n:No?):Int{
    if(n == null)
        return 0
    else {
        return 1 + tamanho(n.tail)
    }
}

//multiplicar todos os valores da lista por uma constante (fornecida como argumento )

fun multiplicar(x:Int, n:No?):No? =
    if( n == null ) null
    else{
        No(n.head*x,multiplicar(x,n.tail))
    }
// substituir todos os valores m da lista por um valor cte n ( fornecidos como argumentos)

fun substituir(m:Int,n:Int,t:No?):No?=
    if(t == null)
        null
    else{
        if(m == t.head )
            No(n,substituir(m,n,t.tail))
        else{
            No(t.head,substituir(m,n,t.tail))
        }
    }

// descartar os n's primeiros elementos de uma lista(n é argumento)

fun descartar(x:Int, n:No?):No?=
        if(n==null) null
        else{
           if(x==0)
               No(n.head,n.tail)
            else{
               descartar(x-1,n.tail)
           }
        }

// retornar o maior valor da lista

fun maior(lista:No?, n:Int = 0):Int{
    if(lista==null)
        return -1
    else{
        if(lista.head > n && lista.tail == null)
            return lista.head
        else if (lista.head > n && lista.tail != null)
            return maior(lista.tail,lista.head)
        else
            return maior(lista.tail, n)

    }
}

//inserir numero numa lista ordenada

fun insord(x:Int,lista:No?):No?=
    if(lista==null)
        null
    else{
        if(x <= lista.head)
            No(x,lista)
        else{
            No(lista.head,insord(x,lista.tail))
        }
    }


val l3 = No(2,No(1,null))



println("antes de adicionar "  + l3)
println("adicionando 4 = " + insord(4,l3))



//println(descartar(2,l2))
//println(l1)
//println("substituir 2 por 9" + substituir(2,9,l1))