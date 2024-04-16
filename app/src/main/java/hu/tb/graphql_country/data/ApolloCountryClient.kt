package hu.tb.graphql_country.data

import com.apollographql.apollo3.ApolloClient
import hu.tb.CountriesQuery
import hu.tb.CountryQuery
import hu.tb.graphql_country.domain.CountryClient
import hu.tb.graphql_country.domain.DetailedCountry
import hu.tb.graphql_country.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> = apolloClient
        .query(CountriesQuery())
        .execute()
        .data
        ?.countries
        ?.map { it.toSimpleCountry() }
        ?: emptyList()

    override suspend fun getCountry(code: String): DetailedCountry? = apolloClient
        .query(CountryQuery(code))
        .execute()
        .data
        ?.country
        ?.toDetailedCountry()
}