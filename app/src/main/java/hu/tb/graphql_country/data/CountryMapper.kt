package hu.tb.graphql_country.data

import hu.tb.CountriesQuery
import hu.tb.CountryQuery
import hu.tb.graphql_country.domain.DetailedCountry
import hu.tb.graphql_country.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry =
    DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry =
    SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )