
# UserCreateRequest

Request to create a new user

## Properties

Name | Type
------------ | -------------
`name` | string
`email` | string
`age` | number

## Example

```typescript
import type { UserCreateRequest } from ''

// TODO: Update the object below with actual values
const example = {
  "name": John Doe,
  "email": john@example.com,
  "age": 25,
} satisfies UserCreateRequest

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as UserCreateRequest
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


