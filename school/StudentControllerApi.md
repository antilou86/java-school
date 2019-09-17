# StudentControllerApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewStudentUsingPOST**](StudentControllerApi.md#addNewStudentUsingPOST) | **POST** /students/Student | addNewStudent
[**deleteStudentByIdUsingDELETE**](StudentControllerApi.md#deleteStudentByIdUsingDELETE) | **DELETE** /students/Student/{Studentid} | deleteStudentById
[**getStudentByIdUsingGET**](StudentControllerApi.md#getStudentByIdUsingGET) | **GET** /students/Student/{StudentId} | getStudentById
[**getStudentByNameContainingUsingGET**](StudentControllerApi.md#getStudentByNameContainingUsingGET) | **GET** /students/student/namelike/{name} | getStudentByNameContaining
[**listAllStudentsUsingGET**](StudentControllerApi.md#listAllStudentsUsingGET) | **GET** /students/students | listAllStudents
[**updateStudentUsingPUT**](StudentControllerApi.md#updateStudentUsingPUT) | **PUT** /students/Student/{Studentid} | updateStudent


## **addNewStudentUsingPOST**

addNewStudent

### Example
```bash
 addNewStudentUsingPOST
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStudent** | [**Student**](Student.md) | newStudent |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteStudentByIdUsingDELETE**

deleteStudentById

### Example
```bash
 deleteStudentByIdUsingDELETE Studentid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentid** | **integer** | Studentid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getStudentByIdUsingGET**

getStudentById

### Example
```bash
 getStudentByIdUsingGET StudentId=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **integer** | StudentId |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getStudentByNameContainingUsingGET**

getStudentByNameContaining

### Example
```bash
 getStudentByNameContainingUsingGET name=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **string** | name |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllStudentsUsingGET**

listAllStudents

### Example
```bash
 listAllStudentsUsingGET
```

### Parameters
This endpoint does not need any parameter.

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateStudentUsingPUT**

updateStudent

### Example
```bash
 updateStudentUsingPUT Studentid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentid** | **integer** | Studentid |
 **updateStudent** | [**Student**](Student.md) | updateStudent |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

