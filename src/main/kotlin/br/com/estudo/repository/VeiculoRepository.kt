package br.com.estudo.repository

import br.com.estudo.model.Veiculo
import com.mongodb.client.FindIterable
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.result.InsertOneResult
import jakarta.inject.Singleton

@Singleton
class VeiculoRepository(
    private val mongoClient: MongoClient
) {
    fun create(veiculo: Veiculo): InsertOneResult {
    return getConnect().insertOne(veiculo)
    }

    fun getAll(): FindIterable<Veiculo> {
        return getConnect().find()
    }

    private fun getConnect(): MongoCollection<Veiculo> {
        return mongoClient
            .getDatabase("test")
            .getCollection("veiculo", Veiculo::class.java)
    }
}