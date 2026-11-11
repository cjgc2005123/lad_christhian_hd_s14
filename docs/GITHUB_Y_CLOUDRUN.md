# Despliegue manual progresivo: GitHub -> Google Cloud Run

## Fase 1: GitHub (almacenar código y ejecutar CI)

1. Crear repositorio vacío `frontend-java-ci-cd` en GitHub.
2. En VS Code, dentro de la raíz del proyecto:

```powershell
git init
git branch -M main
git add .
git diff --cached --name-only
git commit -m "LAB03: frontend Java con Maven"
git remote add origin https://github.com/TU_USUARIO/frontend-java-ci-cd.git
git push -u origin main
```

3. Abrir pestaña **Actions**, workflow **CI - Frontend Java**.
4. Esperar a que GitHub ejecute tests y empaquete JAR. Si falla, revisar logs de `Compilar y probar`.

GitHub NO ejecuta la página para visitantes; solo hospeda el código y ejecuta pruebas. GitHub Pages podría hospedar solo el HTML estático, sin Java; este laboratorio se centra en un servicio Java real.

## Fase 2: desplegar en Google Cloud Run

Prerequisitos: proyecto Google Cloud con facturación habilitada y permisos para habilitar API, compilar y desplegar servicios. Cloud Run/Cloud Build/Artifact Registry pueden generar costos.

Abrir Cloud Shell en `https://console.cloud.google.com/` y ejecutar (cambiar identificadores):

```bash
export PROJECT_ID="TU_PROJECT_ID"
export REGION="us-central1"
gcloud config set project "$PROJECT_ID"
gcloud services enable run.googleapis.com cloudbuild.googleapis.com artifactregistry.googleapis.com

git clone https://github.com/TU_USUARIO/frontend-java-ci-cd.git
cd frontend-java-ci-cd

gcloud run deploy frontend-java-lab \
  --source . \
  --region "$REGION" \
  --allow-unauthenticated
```

`gcloud run deploy --source .` utiliza el Dockerfile incluido para construir la imagen. La compilación consume recursos de Cloud Build y publica la imagen en Artifact Registry.

En organizaciones con política que impida acceso público, deberá usar autenticación en lugar de `--allow-unauthenticated`.

## ¿Y Vertex AI?

Vertex AI se incorpora cuando la aplicación necesite IA (por ejemplo, un botón que llame a un modelo). Para alojar una web Java, Cloud Run es el servicio adecuado. No se incluyen llamadas a Vertex AI porque este laboratorio no requiere modelos ni credenciales de IA.

## Fase 3 opcional: CD automático

Tras comprobar el despliegue manual, conectar el repositorio GitHub a Cloud Run mediante configuración de despliegue continuo, o crear un workflow autenticado con Workload Identity Federation (sin claves JSON). Configurar primero IAM y verificación de identidad; no copiar secretos en YAML.

## Limpieza del laboratorio

```bash
gcloud run services delete frontend-java-lab --region "$REGION"
```

Verificar también imágenes de Artifact Registry, compilaciones, repositorios y cualquier otro recurso facturable antes de dar por finalizado el ejercicio.
