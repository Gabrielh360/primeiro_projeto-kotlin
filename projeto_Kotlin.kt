enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val aluno: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("[LOG] ${usuario.aluno} já está inscrito(a) nesta formação.")
        } else {
            inscritos.add(usuario)
            println("[LOG] ${usuario.aluno} foi inscrito(a) em ${this.nome}.")
        }
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
    
}

fun main() {
    val usuario1 = Usuario("Gabriel", 21)
    val usuario2 = Usuario("Lucas", 24)
    val usuario3 = Usuario("João", 19)
    val usuario4 = Usuario("Ana", 33)
    val usuario5 = Usuario("Rafael", 20)
    val usuario6 = Usuario("Jessica", 27)
    
    val conteudo1 = ConteudoEducacional("Santander Bootcamp 2023 - Mobile Android com Kotlin", 98, Nivel.INTERMEDIARIO)
    val conteudo2 = ConteudoEducacional("Santander Bootcamp 2023 - Mobile iOS com Swift", 89, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Santander Bootcamp 2023 - Mobile com Flutter", 89, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Santander Bootcamp 2023 - Ciência de Dados com Python", 89, Nivel.INTERMEDIARIO)
    val conteudo5 = ConteudoEducacional("Santander Bootcamp 2023 - Backend Java", 88, Nivel.INTERMEDIARIO)
    val conteudo6 = ConteudoEducacional("Santander Bootcamp 2023 - Fullstack Java+Angular", 115, Nivel.INTERMEDIARIO)
    
    val formacao1 = Formacao("Mobile Android com Kotlin", listOf(conteudo1))
    val formacao2 = Formacao("Mobile iOS com Swift", listOf(conteudo2))    
    val formacao3 = Formacao("Mobile com Flutter", listOf(conteudo3))
    val formacao4 = Formacao("Ciência de Dados com Python", listOf(conteudo4))
    val formacao5 = Formacao("Backend Java", listOf(conteudo5))
    val formacao6 = Formacao("Fullstack Java+Angula", listOf(conteudo6))
    
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)
    formacao4.matricular(usuario4)
    formacao5.matricular(usuario5)
    formacao6.matricular(usuario6)
    
    println()
    
    println("[INSCRIÇÕES]")
    println("Inscritos na formção ${formacao1.nome}: ${formacao1.inscritos}")
    println("Inscritos na formção ${formacao2.nome}: ${formacao2.inscritos}")
    println("Inscritos na formção ${formacao3.nome}: ${formacao3.inscritos}")
    println("Inscritos na formção ${formacao4.nome}: ${formacao4.inscritos}")
    println("Inscritos na formção ${formacao5.nome}: ${formacao5.inscritos}")
    println("Inscritos na formção ${formacao6.nome}: ${formacao6.inscritos}")
    
    println()
    
    println("[CONTEUDO INFO] ${conteudo1}")
    println("[CONTEUDO INFO] ${conteudo2}")
    println("[CONTEUDO INFO] ${conteudo3}")
    println("[CONTEUDO INFO] ${conteudo4}")
    println("[CONTEUDO INFO] ${conteudo5}")
    println("[CONTEUDO INFO] ${conteudo6}")
    
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}