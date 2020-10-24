import java.math.BigDecimal
import java.time.LocalDate

enum class ExpenseStatus{ Paid, NotPaid }

data class Expense(
    val id: Int, val name: String, val price: BigDecimal, val status: ExpenseStatus,
    val dueDate: LocalDate, val description: String = ""
){
    override fun toString(): String {
        return "Expense $id, Name: $name, Price: $price, Status: $status"
    }
}

fun main(){
    println("Hello Monica! Lets start to play ")

    var expenses = mutableListOf(
        Expense(1, "expense1", BigDecimal(200), ExpenseStatus.NotPaid, LocalDate.now()),
        Expense(2, "expense2", BigDecimal(100), ExpenseStatus.Paid, LocalDate.now())
    );

    //print all expenses
    println("---- Print all expenses ----")
    expenses.forEach{ println(it); }

    //print total amount
    println("---- Print total amount ----")
    val sum = expenses.stream().map{it.price}.reduce(BigDecimal.ZERO, BigDecimal::add)
    println("Total Amount: $sum")

    //add expense
    println("---- Add expense 3 and print all expenses ----")
    expenses.add(Expense(3, "expense3", BigDecimal(30), ExpenseStatus.NotPaid, LocalDate.now()))
    expenses.forEach{ println(it); }

    //remove all expenses with price less than 100
    println("----- Remove all expenses with price less than 100 and print all again -----")
    expenses.removeIf { it.price < BigDecimal(100) }
    expenses.forEach{ println(it); }
}
