# Into Factor House

## Introduction

This is a take-home technical test designed to be fun and allow you to show a little creativity, it is based on real code that we have implemented more than once.

There is no time-limit on this challenge, take as long or as little as you like.

## Details

You will likely want to install Leiningen, once installed you can run 'lein test' in the root directory to run tests.

There are three files:

1. [factorhouse.kafka.topic.clj](src/factorhouse/kafka/topic.clj) contains the functions that we would like you to implement
2. [factorhouse.kafka.topic-test.clj](test/factorhouse/kafka/topic_test.clj)  contains three tests that currently fail
3. [factorhouse.test.data.cljc](test/factorhouse/test/data.clj) contains the test data and description of what it all means

There is one principal technical challenge:

1. Implement the factorhouse.kafka.topic/sizes function, causing the first test to pass.

There is an extension technical challenge:

2. Implement the remaining functions, causing all the tests to pass.

Good luck!

## Reality

We use this technique to produce data that drives charts in our UI like:

![Screenshot](resources/img/chart.png)

For more examples take a look at our [live demo site](https://demo.kpow.io).

## Copyright / License

Copyright © 2024 Factor House Pty. Ltd.

Distributed under the Eclipse Public License either version 2.0 or (at your option) any later version.
