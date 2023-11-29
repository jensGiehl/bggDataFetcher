#!/bin/bash

current_version=$(mvn help:evaluate -Dexpression="project.version" -q -DforceStdout)

if [ -z "$current_version" ]; then
  echo "No version found :("
  exit 1
fi

echo "Current version: $current_version"

major=$(echo "$current_version" | cut -d'.' -f1)
minor=$(echo "$current_version" | cut -d'.' -f2)
patch=$(echo "$current_version" | cut -d'.' -f3)

patch=$((patch + 1))

new_version="$major.$minor.$patch"

echo "New version: $new_version"

mvn versions:set -DnewVersion="$new_version" -q

git config --global user.name 'Version Bumper'
git config --global user.email 'jensGiehl@users.noreply.github.com'
git commit -am "[skip ci] Bump version to $new_version" > /dev/null && git push
