//link:- https://stackoverflow.com/questions/44117970/kotlin-data-class-from-json-using-gson
//Q) Why do you use the SerializedName annotation instead of the field naming strategy, Vasily? –
//because @SerializedName will allow me to use custom names of the variables which may not match with json key.
//And yes, you may not use @SerializedName if you do not need it.

//HTTP Headers are mostly used to add metadata information in an API request and response. There is a wealth of
//information that you can put in these headers. This data is mostly used to describe the content of the
//Request/Response body. Some of the examples of Headers are: Auth tokens, Session-id, Content-Type, App Version,
//Content-Length etc.