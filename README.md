# Java CI/CD Template Project

This repository serves as a **template project for Java development**, designed to demonstrate and standardize **continuous integration (CI) and code quality practices** for Java projects. It provides a ready-to-use configuration for automated builds, static analysis, and formatting checks.

---

## Key Features

- **Gradle-based build system**
  - Java compilation, testing, and packaging.
  - ErrorProne static analysis integrated.
  - PMD and SpotBugs for code quality checks.

- **Code formatting and style enforcement**
  - [Spotless](https://github.com/diffplug/spotless) with Google Java Format (AOSP variant).
  - [Checkstyle](https://checkstyle.org/) for consistent coding style.

- **Pre-commit hooks**
  - Ensures code quality checks run automatically before commits.
  - Cross-platform support (Windows, macOS, Linux).
  - Includes hooks for formatting, linting, and other safety checks.

- **GitHub Actions CI workflow**
  - Automatically runs all code quality and build checks on pull requests.
  - Uploads reports for easy inspection.
  - Demonstrates a modern CI/CD setup for Java projects.

---

## Getting Started

### Prerequisites

- **Java 25+**
- **Gradle** (wrapper included)
- **Python 3.8+** (for `pre-commit`)
- **Pre-commit**: Install via `pip install pre-commit`

### Setup

1. Install pre-commit hooks:

```bash
python -m pre_commit install
```

2. Run all pre-commit checks manually (optional):

```bash
python -m pre_commit run --all-files --verbose
```

3. Run all code quality checks:

```bash
./gradlew codeQuality
```

The codeQuality task aggregates Spotless, Checkstyle, SpotBugs, and PMD checks in a single step.
