
fun main() {
    val usMoney01 = USMoney(getUserInput("Dollar 01: "),getUserInput("Cents 01: "))
    val usMoney02 = USMoney(getUserInput("Dollar 02: "),getUserInput("Cents 02: "))
    println("$usMoney01 + $usMoney02 => ${usMoney01.plus(usMoney02)}")
}

fun getUserInput(msg : String): Int{
    print(msg)
    return getIntFromConsole(msg)
}

fun getIntFromConsole(msg: String): Int {
    return try {
        readLine()!!.toInt()
    } catch (e: Exception) {
        println("Erro: Não foi possível realizar o parser do inteiro.")
        getUserInput(msg)
    }
}

class USMoney(dollars: Int = 0, cents: Int = 0) {
    private var dollars: Int = 0
    private var cents: Int = 0

    init {
        setDollars(dollars)
        setCents(cents)
    }

    private fun getDollars(): Int {
        return this.dollars
    }
    private fun setDollars(a: Int) {
        this.dollars = a
    }
    private fun getCents() : Int{
        return this.cents
    }
    private fun setCents(a: Int) {
        this.cents    = a % 100
        this.dollars += a / 100
    }

    override fun toString() : String{

        val centsStr : String = if(this.cents < 10){
            "0${this.getCents()}"
        } else{
            this.getCents().toString()
        }

        return "US$ ${this.getDollars()}.${centsStr}"
    }

    fun plus(a : USMoney) : USMoney{
        return USMoney(this.getDollars() + a.getDollars(), this.getCents() + a.getCents())
    }
}
