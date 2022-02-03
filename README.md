<div align="center">
    <hr/>
        <h1 align="center" style="border-bottom: none">Koios Java Client</h1>

[![License](https://img.shields.io/badge/License-Apache_2.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0) ![Build Status](https://github.com/edridudi/koios-java-client/actions/workflows/.github/workflows/maven.yml/badge.svg)
<hr/>
</div>

## What is Koios?
**Koios** Java Client Library is based on [Koios](https://www.koios.rest/) Elastic Query Layer for [Cardano Node](https://github.com/input-output-hk/cardano-node/) by [Cardano Community Guild Operators](https://github.com/cardano-community). <br>
**Koios** is best described as a Decentralized and Elastic RESTful query layer for exploring data on Cardano blockchain to consume within applications/wallets/explorers/etc. <br>
Resource and maintenance requirements for Cardano blockchain components (e.g. cardano-node, cardano-db-sync) are ever-growing. Along with that, every builder needs to identify how to query complex information from the chain.

## Overview
**Koios Java Client** is a Java REST Client library which allows interacting with **Koios** Server Instances using Java Objects.

## Features
- Synchronous REST messaging using java objects
- Structured Java Objects logging
- Supported REST Services:
    - [x] Network
        - Chain Tip
        - Genesis Info
        - Historical Tokenomic Statistics
    - [x] Epoch
        - Epoch Information
        - Epoch's Protocol Parameters
    - [x] Block
        - Block List
        - Block Information
        - Block Transactions
    - [x] Transactions
        - Transaction Information
        - Transaction UTxOs
        - Transaction Metadata
        - Transaction Metadata Labels
        - Transaction Submission
        - Transaction Status (Block Confirmations)
    - [x] Address
        - Address Information
        - Address Transactions
        - Transactions from Payment Credentials
        - Address Assets
    - [x] Account
        - List of All Accounts
        - Account Information
        - Account Rewards
        - Account Updates (History)
        - Account Addresses
        - Account Assets
        - Account History
    - [x] Asset
        - Assets Address List
        - Asset Information
        - Asset Summary
        - Assets List
    - [x] Pool
        - Pool List
        - Pool Information
        - Pool Delegators List
        - Pool Blocks
        - Pool Updates (History)
        - Pool Relays
        - Pool Metadata
    - [x] Script
        - Script List
        - Script Redeemers

<hr/>
<div align="center">

</div>

<p align="center">
<a href="CONTRIBUTING.md">:triangular_ruler: Contributing</a>
  |
<a href="SPONSORS.md">:gift_heart: Sponsors</a>
</p>