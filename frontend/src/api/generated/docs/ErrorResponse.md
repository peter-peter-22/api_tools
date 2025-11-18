
# ErrorResponse


## Properties

Name | Type
------------ | -------------
`body` | [ProblemDetail](ProblemDetail.md)
`statusCode` | [ErrorResponseStatusCode](ErrorResponseStatusCode.md)
`detailMessageArguments` | Array&lt;any&gt;
`typeMessageCode` | string
`detailMessageCode` | string
`titleMessageCode` | string
`headers` | [ErrorResponseHeaders](ErrorResponseHeaders.md)

## Example

```typescript
import type { ErrorResponse } from ''

// TODO: Update the object below with actual values
const example = {
  "body": null,
  "statusCode": null,
  "detailMessageArguments": null,
  "typeMessageCode": null,
  "detailMessageCode": null,
  "titleMessageCode": null,
  "headers": null,
} satisfies ErrorResponse

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ErrorResponse
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


