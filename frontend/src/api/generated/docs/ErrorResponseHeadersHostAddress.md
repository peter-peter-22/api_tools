
# ErrorResponseHeadersHostAddress


## Properties

Name | Type
------------ | -------------
`hostAddress` | string
`address` | string
`hostName` | string
`linkLocalAddress` | boolean
`multicastAddress` | boolean
`anyLocalAddress` | boolean
`loopbackAddress` | boolean
`siteLocalAddress` | boolean
`mcglobal` | boolean
`mcnodeLocal` | boolean
`mclinkLocal` | boolean
`mcsiteLocal` | boolean
`mcorgLocal` | boolean
`canonicalHostName` | string

## Example

```typescript
import type { ErrorResponseHeadersHostAddress } from ''

// TODO: Update the object below with actual values
const example = {
  "hostAddress": null,
  "address": null,
  "hostName": null,
  "linkLocalAddress": null,
  "multicastAddress": null,
  "anyLocalAddress": null,
  "loopbackAddress": null,
  "siteLocalAddress": null,
  "mcglobal": null,
  "mcnodeLocal": null,
  "mclinkLocal": null,
  "mcsiteLocal": null,
  "mcorgLocal": null,
  "canonicalHostName": null,
} satisfies ErrorResponseHeadersHostAddress

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ErrorResponseHeadersHostAddress
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


