
# ErrorResponseHeaders


## Properties

Name | Type
------------ | -------------
`contentDisposition` | [ContentDisposition](ContentDisposition.md)
`acceptCharset` | Array&lt;string&gt;
`location` | string
`empty` | boolean
`host` | [ErrorResponseHeadersHost](ErrorResponseHeadersHost.md)
`all` | { [key: string]: string; }
`lastModified` | number
`date` | number
`contentLength` | number
`origin` | string
`range` | Array&lt;any&gt;
`allow` | Set&lt;any&gt;
`cacheControl` | string
`contentLanguage` | string
`etag` | string
`accept` | [Array&lt;MediaType&gt;](MediaType.md)
`accessControlAllowOrigin` | string
`accessControlAllowMethods` | Array&lt;any&gt;
`accessControlAllowHeaders` | Array&lt;string&gt;
`accessControlExposeHeaders` | Array&lt;string&gt;
`accessControlAllowCredentials` | boolean
`accessControlMaxAge` | number
`accessControlRequestMethod` | any
`accessControlRequestHeaders` | Array&lt;string&gt;
`acceptPatch` | [Array&lt;MediaType&gt;](MediaType.md)
`acceptLanguage` | [Array&lt;ErrorResponseHeadersAcceptLanguageInner&gt;](ErrorResponseHeadersAcceptLanguageInner.md)
`basicAuth` | string
`acceptLanguageAsLocales` | Array&lt;string&gt;
`bearerAuth` | string
`connection` | Array&lt;string&gt;
`expires` | number
`ifMatch` | Array&lt;string&gt;
`ifNoneMatch` | Array&lt;string&gt;
`ifUnmodifiedSince` | number
`pragma` | string
`upgrade` | string
`vary` | Array&lt;string&gt;
`ifModifiedSince` | number
`contentType` | [MediaType](MediaType.md)

## Example

```typescript
import type { ErrorResponseHeaders } from ''

// TODO: Update the object below with actual values
const example = {
  "contentDisposition": null,
  "acceptCharset": null,
  "location": null,
  "empty": null,
  "host": null,
  "all": null,
  "lastModified": null,
  "date": null,
  "contentLength": null,
  "origin": null,
  "range": null,
  "allow": null,
  "cacheControl": null,
  "contentLanguage": null,
  "etag": null,
  "accept": null,
  "accessControlAllowOrigin": null,
  "accessControlAllowMethods": null,
  "accessControlAllowHeaders": null,
  "accessControlExposeHeaders": null,
  "accessControlAllowCredentials": null,
  "accessControlMaxAge": null,
  "accessControlRequestMethod": null,
  "accessControlRequestHeaders": null,
  "acceptPatch": null,
  "acceptLanguage": null,
  "basicAuth": null,
  "acceptLanguageAsLocales": null,
  "bearerAuth": null,
  "connection": null,
  "expires": null,
  "ifMatch": null,
  "ifNoneMatch": null,
  "ifUnmodifiedSince": null,
  "pragma": null,
  "upgrade": null,
  "vary": null,
  "ifModifiedSince": null,
  "contentType": null,
} satisfies ErrorResponseHeaders

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ErrorResponseHeaders
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


