# Construcción razonada de .gitignore

| Tipo | Ejemplo | ¿Subir? | Razón |
|---|---|---|---|
| Código fuente | `src/main/java` | Sí | Permite reconstruir la aplicación |
| Página web | `src/main/resources/static/index.html` | Sí | Es el frontend |
| Manifiesto | `pom.xml` | Sí | Define build y dependencias |
| Pruebas | `src/test` | Sí | CI debe ejecutarlas |
| Workflow | `.github/workflows/ci-java.yml` | Sí | Define CI |
| Artefactos | `target/` | No | Maven los regenera |
| Secretos | `.env`, `*.key` | No | Nunca publicar claves |
| Plantilla | `.env.example` | Sí | Documenta opciones sin secretos |
| Credenciales generadas | `gha-creds-*.json` | No | Google Actions crea estos archivos |

## Comprobación

```powershell
git init
git check-ignore -v target/demo.class
git check-ignore -v .env
git status --short --untracked-files=all
git add .
git diff --cached --name-only
```

Si algo sensible se subió por error, ignorarlo después no lo borra del historial: revocar las credenciales y corregir el historial según corresponda.
