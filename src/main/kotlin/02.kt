enum class Carta(val numero: Int, val naipe: String) {
    // Paus
    AS_PAUS(1, "P"),
    DOIS_PAUS(2, "P"),
    TRES_PAUS(3, "P"),
    QUATRO_PAUS(4, "P"),
    CINCO_PAUS(5, "P"),
    SEIS_PAUS(6, "P"),
    SETE_PAUS(7, "P"),
    OITO_PAUS(8, "P"),
    NOVE_PAUS(9, "P"),
    DEZ_PAUS(10, "P"),
    VALETE_PAUS(11, "P"),
    DAMA_PAUS(12, "P"),
    REI_PAUS(13, "P"),

    // Copas
    AS_COPAS(1, "C"),
    DOIS_COPAS(2, "C"),
    TRES_COPAS(3, "C"),
    QUATRO_COPAS(4, "C"),
    CINCO_COPAS(5, "C"),
    SEIS_COPAS(6, "C"),
    SETE_COPAS(7, "C"),
    OITO_COPAS(8, "C"),
    NOVE_COPAS(9, "C"),
    DEZ_COPAS(10, "C"),
    VALETE_COPAS(11, "C"),
    DAMA_COPAS(12, "C"),
    REI_COPAS(13, "C"),

    // Ouro
    AS_OURO(1, "O"),
    DOIS_OURO(2, "O"),
    TRES_OURO(3, "O"),
    QUATRO_OURO(4, "O"),
    CINCO_OURO(5, "O"),
    SEIS_OURO(6, "O"),
    SETE_OURO(7, "O"),
    OITO_OURO(8, "O"),
    NOVE_OURO(9, "O"),
    DEZ_OURO(10, "O"),
    VALETE_OURO(11, "O"),
    DAMA_OURO(12, "O"),
    REI_OURO(13, "O"),

    // Espadas
    AS_ESPADAS(1, "E"),
    DOIS_ESPADAS(2, "E"),
    TRES_ESPADAS(3, "E"),
    QUATRO_ESPADAS(4, "E"),
    CINCO_ESPADAS(5, "E"),
    SEIS_ESPADAS(6, "E"),
    SETE_ESPADAS(7, "E"),
    OITO_ESPADAS(8, "E"),
    NOVE_ESPADAS(9, "E"),
    DEZ_ESPADAS(10, "E"),
    VALETE_ESPADAS(11, "E"),
    DAMA_ESPADAS(12, "E"),
    REI_ESPADAS(13, "E");

    companion object {
        fun getByNumeroAndNaipe(numero: Int, naipe: String): Carta {
            val r : Carta? = values().find { it.numero == numero && it.naipe == naipe }
            if(r == null){
                throw IllegalArgumentException("Carta invalida!")
            } else{
                return r
            }
        }
    }
}


fun getUserInputIntCartas(msg : String): Int{
    print(msg)
    return getIntFromConsoleCartas(msg)
}

fun getIntFromConsoleCartas(msg: String): Int {
    return try {
        readLine()!!.toInt()
    } catch (e: Exception) {
        println("Erro: Não foi possível realizar o parser do inteiro.")
        getUserInputIntCartas(msg)
    }
}

fun getUserInputStringCartas(msg : String): String{
    print(msg)
    return getStringFromConsoleCartas(msg)
}

fun getStringFromConsoleCartas(msg: String): String {
    return try {
        readLine()!!.toString()
    } catch (e: Exception) {
        println("Erro: Não foi possível realizar o parser do inteiro.")
        getUserInputStringCartas(msg)
    }
}

fun getUserInputCartas() : Carta{
    return try{
        Carta.getByNumeroAndNaipe(
            getUserInputIntCartas("Insira o número da carta: ")
            ,   getUserInputStringCartas("Insira o naipe da carta: ")
        )
    } catch (e: Exception) {
        println("Carta invalida!")
        getUserInputCartas()
    }
}

fun fullHouseVerify(cartas : List<Carta>){
    val map : HashMap<Int,Int> = HashMap()
    for(carta in cartas){
        val count = map.getOrDefault(carta.numero, 0)
        map[carta.numero] = count + 1
    }

    var temTrinca = false
    var temPar = false

    for (entry in map.entries) {
        if (entry.value == 3) {
            temTrinca = true
        } else if (entry.value == 2) {
            temPar = true
        }
    }

    if (temTrinca && temPar) {
        println("Full House!")
    } else {
        println("Não é um Full House.")
    }
}

fun main(){
    val cartas = arrayListOf<Carta>()
    for (i in (1 .. 5)){
        cartas.add(getUserInputCartas())
        println(cartas.toString())
    }
    fullHouseVerify(cartas)
}