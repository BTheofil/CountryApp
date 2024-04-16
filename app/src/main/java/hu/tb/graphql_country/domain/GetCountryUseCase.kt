package hu.tb.graphql_country.domain

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? = countryClient
        .getCountry(code)

}