# RecipeApi

All URIs are relative to *http://www.recipepuppy.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getRecipe**](RecipeApi.md#getRecipe) | **GET** /api/ | Get Recipe


<a name="getRecipe"></a>
# **getRecipe**
> RecipeList getRecipe(i, q, p)

Get Recipe

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = RecipeApi()
val i : kotlin.String = i_example // kotlin.String | Ingredient
val q : kotlin.String = q_example // kotlin.String | Query
val p : kotlin.Int = 56 // kotlin.Int | Paging
try {
    val result : RecipeList = apiInstance.getRecipe(i, q, p)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecipeApi#getRecipe")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecipeApi#getRecipe")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **i** | **kotlin.String**| Ingredient |
 **q** | **kotlin.String**| Query | [optional]
 **p** | **kotlin.Int**| Paging | [optional]

### Return type

[**RecipeList**](RecipeList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

