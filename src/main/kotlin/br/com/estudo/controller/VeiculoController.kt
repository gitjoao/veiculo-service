package br.com.estudo.controller
import br.com.estudo.dto.InputVeiculo
import br.com.estudo.model.Veiculo
import br.com.estudo.service.VeiculoService
import com.mongodb.client.FindIterable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import java.util.*

@Controller("/veiculos")
class VeiculoController (
    private val veiculoService: VeiculoService
    ) {

    @Get
    fun getAll(): FindIterable<Veiculo> {
        return veiculoService.getAll()
    }

    @Post
    fun create(@Body veiculo: InputVeiculo): HttpResponse<Veiculo> {
        val newVeiculo = Veiculo(
            veiculoId = UUID.randomUUID().toString(),
            marca = veiculo.marca,
            modelo = veiculo.modelo,
            placa = veiculo.placa)
        veiculoService.create(newVeiculo)
        return HttpResponse.created(newVeiculo)
    }
}