
# ContentDisposition


## Properties

Name | Type
------------ | -------------
`type` | string
`name` | string
`filename` | string
`charset` | string
`size` | number
`creationDate` | Date
`modificationDate` | Date
`readDate` | Date
`attachment` | boolean
`formData` | boolean
`inline` | boolean

## Example

```typescript
import type { ContentDisposition } from ''

// TODO: Update the object below with actual values
const example = {
  "type": null,
  "name": null,
  "filename": null,
  "charset": null,
  "size": null,
  "creationDate": null,
  "modificationDate": null,
  "readDate": null,
  "attachment": null,
  "formData": null,
  "inline": null,
} satisfies ContentDisposition

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ContentDisposition
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


