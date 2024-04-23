# Domain-Oriented Structure Migration

## Overview
This pull request encompasses the migration of the existing Scala codebase to a domain-oriented structure. The migration involved reorganizing the codebase into separate domains "A" through "E", ensuring that each domain is independent and does not share code with others. The `SparkOp` abstraction has been converted to `SubdomainOp`, with external references moved to a shared `/subdomains/utils` directory.

## Changes
- Created independent domains "A" through "E" within the `/subdomains` directory.
- Migrated `SparkOp` instances to `SubdomainOp` and updated their references accordingly.
- Moved shared utilities and external references to the `/subdomains/utils` directory.
- Updated package names and import statements to reflect the new domain-oriented structure.
- Removed placeholder inputs from `SubdomainOp` instances to ensure all tests pass.

## Testing
- Updated the `DAGConfigurationSpec.scala` test to check for the existence of `SubdomainOp` inputs within the DAG.
- Ensured that all tests pass, confirming the correctness of the domain-oriented structure.

## Notes
- The code has been structured to facilitate future expansions and modifications within each domain.
- The `SubdomainOp` abstraction is now the standard for operation instances within the codebase.

Please review the changes and provide feedback or approval for the merge.
