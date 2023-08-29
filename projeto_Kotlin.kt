enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val aluno: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
           	throw IllegalArgumentException("${usuario.aluno} já está inscrito(a) nesta formação.")
        } else {
            inscritos.add(usuario) 
            log("${usuario.aluno} foi inscrito(a) em $nome.")
        }

    }
    
    private fun log(message: String) {
        println("[LOG] $message")
    }
    
}


fun main() {
    val usuarios = listOf(
    	Usuario("Gabriel", 21),
    	Usuario("Lucas", 24),
    	Usuario("João", 19),
    	Usuario("Ana", 33),
    	Usuario("Rafael", 20),
    	Usuario("Jessica", 27)
    )
    
    
    val conteudos = listOf(
    	ConteudoEducacional("Santander Bootcamp 2023 - Mobile Android com Kotlin", 98, Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Santander Bootcamp 2023 - Mobile iOS com Swift", 89, Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Santander Bootcamp 2023 - Mobile com Flutter", 89, Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Santander Bootcamp 2023 - Ciência de Dados com Python", 89, Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Santander Bootcamp 2023 - Backend Java", 88, Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Santander Bootcamp 2023 - Fullstack Java+Angular", 115, Nivel.INTERMEDIARIO)
    )
    
    
    val formacoes = listOf(
    	Formacao("Mobile Android com Kotlin", listOf(conteudos[0])),
    	Formacao("Mobile iOS com Swift", listOf(conteudos[1])),    
    	Formacao("Mobile com Flutter", listOf(conteudos[2])),
    	Formacao("Ciência de Dados com Python", listOf(conteudos[3])),
    	Formacao("Backend Java", listOf(conteudos[4])),
    	Formacao("Fullstack Java+Angula", listOf(conteudos[5]))
    )
    
    
    formacoes[0].matricular(usuarios[0])
    formacoes[1].matricular(usuarios[1])
    formacoes[2].matricular(usuarios[2])
    formacoes[3].matricular(usuarios[3])
    formacoes[4].matricular(usuarios[4])
    formacoes[5].matricular(usuarios[5])
    
    
    println("\n[INSCRIÇÕES]")
    for (formacao in formacoes) {
        println("Inscritos na formção ${formacao.nome}: ${formacao.inscritos}")
    }
    
    println()
    
    for (conteudo in conteudos) {
        println("[CONTEUDO INFO] $conteudo")
    }
    

}