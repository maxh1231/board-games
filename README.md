## Branching Strategy 🌲

When creating branches, be sure to use the proper naming convention. Each item should by hyphen separated and lowercase.

Example:

```txt
update-readme
```

You can create a new branch and move to it with `git checkout -b new-branch-name`. This will create a copy of whatever branch you started from (typically, it will be the `develop` branch).

You should branch off of the `develop` branch, not `main` as this is where all PRs will point. Be sure your branch is up to date before submitting PRs by running `git rebase develop` while checked out to your branch.

---
