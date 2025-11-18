
# MediaType


## Properties

Name | Type
------------ | -------------
`type` | string
`subtype` | string
`parameters` | { [key: string]: string; }
`qualityValue` | number
`wildcardType` | boolean
`wildcardSubtype` | boolean
`subtypeSuffix` | string
`charset` | string
`concrete` | boolean

## Example

```typescript
import type { MediaType } from ''

// TODO: Update the object below with actual values
const example = {
  "type": null,
  "subtype": null,
  "parameters": null,
  "qualityValue": null,
  "wildcardType": null,
  "wildcardSubtype": null,
  "subtypeSuffix": null,
  "charset": null,
  "concrete": null,
} satisfies MediaType

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MediaType
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


