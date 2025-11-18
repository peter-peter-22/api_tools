
# ErrorResponseHeadersHost


## Properties

Name | Type
------------ | -------------
`hostString` | string
`address` | [ErrorResponseHeadersHostAddress](ErrorResponseHeadersHostAddress.md)
`port` | number
`unresolved` | boolean
`hostName` | string

## Example

```typescript
import type { ErrorResponseHeadersHost } from ''

// TODO: Update the object below with actual values
const example = {
  "hostString": null,
  "address": null,
  "port": null,
  "unresolved": null,
  "hostName": null,
} satisfies ErrorResponseHeadersHost

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ErrorResponseHeadersHost
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


