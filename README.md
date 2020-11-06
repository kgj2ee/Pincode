# PincodeRangeEvaluator

A PincodeRangeEvaluator Service when sent a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), this service will produce the minimum number of ranges required to represent the same restrictions as the input.

## Features
* Input is a range of and domain definitions from/to SwaggerHub.
* Upload multiple API or domains at once.
* Authenticate with an API key for restricted operations (for example, to download private definitions).
* Automatically provision an SCM integration to update source control with changes made to definitions.
* Supports YAML and JSON format for definitions.
* Connects to SwaggerHub SaaS by default, with an optional configuration to point to a local SwaggerHub On-Premise instance.
