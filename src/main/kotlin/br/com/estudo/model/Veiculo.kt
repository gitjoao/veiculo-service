package br.com.estudo.model
import javax.persistence.Entity

@Entity(name = "veiculo")
data class Veiculo(
    val veiculoId: String,
    val modelo: String,
    val marca: String,
    val placa: String
)

