# Python script to add a newline to EOF if not present

from pathlib import Path

def main():
    for file in Path("src").glob("*/*"):
        if not file.is_file():
            continue

        try:
            content = file.read_text()
        except Exception:
            continue

        if not content:
            continue

        fixed = content.rstrip(" \t\n") + "\n"

        if fixed != content:
            file.write_text(fixed)
            print(f"Fixed: {file}")

if __name__ == "__main__":
    main()
