import java.util.*

enum class ExpenseStatus{ Paid, NotPaid }

data class Expense (val id: Int, val name: String, val price: Long, val status: ExpenseStatus,
                    val dueDate: Date, val description: String = ""){
    override fun toString(): String {
        return "Expense $id, Name: $name, Price: $price, Status: $status"
    }
}

fun main(){
    println("Hello Monica! Lets start to play ")

    var expenses = mutableListOf(
            Expense(1,"expense1",200,ExpenseStatus.NotPaid, Date()),
            Expense(2,"expense2",100,ExpenseStatus.Paid, Date())
    );

    //print all expenses
    println("---- Print all expenses ----")
    expenses.forEach{ println(it); }

    //print total amount
    println("---- Print total amount ----")
    val sum = expenses.map {it.price}.sum();
    println("Total Ammount: $sum")

    //add expense
    println("---- Add expense 3 and print all expenses ----")
    expenses.add(Expense(3,"expense3",30,ExpenseStatus.NotPaid, Date()))
    expenses.forEach{ println(it); }

    //remove all expenses with price less than 100
    println("----- Remove all expenses with price less than 100 and print all again -----")
    expenses.removeIf { it.price < 100 }
    expenses.forEach{ println(it); }

}
