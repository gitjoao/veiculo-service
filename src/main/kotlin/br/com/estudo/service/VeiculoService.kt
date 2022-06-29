package br.com.estudo.service

import br.com.estudo.model.Veiculo
import br.com.estudo.repository.VeiculoRepository
import com.mongodb.client.FindIterable
import jakarta.inject.Singleton

@Singleton
class VeiculoService (private val veiculoRepository: VeiculoRepository) {

    fun getAll(): FindIterable<Veiculo> {
        return veiculoRepository.getAll()
    }

    fun create(veiculo: Veiculo) = veiculoRepository.create(veiculo)
}
