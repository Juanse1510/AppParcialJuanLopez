# Calculadora de IMC (Índice de Masa Corporal)

Una aplicación Android moderna desarrollada con Jetpack Compose que permite a los usuarios calcular y monitorear su Índice de Masa Corporal (IMC).

## Características

- 🧮 Cálculo preciso del IMC
- 📊 Historial de registros de IMC
- 🎨 Interfaz de usuario moderna y responsiva
- 🌈 Personalización del color de fondo
- 📱 Diseño adaptativo para diferentes tamaños de pantalla
- 💾 Almacenamiento local de datos usando Room Database

## Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- Room Database
- ViewModel
- Coroutines
- Material Design 3

## Requisitos del Sistema

- Android Studio Hedgehog | 2023.1.1 o superior
- Android SDK 24 (Android 7.0) o superior
- Gradle 8.0 o superior

## Instalación

1. Clona el repositorio:
```bash
https://github.com/Juanse1510/AppParcialJuanLopez.git
```

2. Abre el proyecto en Android Studio

3. Sincroniza el proyecto con Gradle

4. Ejecuta la aplicación en un emulador o dispositivo físico

## Uso

1. Ingresa tu peso en kilogramos
2. Ingresa tu altura en metros (ejemplo: 1.75 para 175 cm)
3. Presiona "Calcular IMC" para ver tu resultado
4. Consulta tu historial de registros en la pantalla de detalles
5. Personaliza el color de fondo en la pantalla de configuración

## Categorías de IMC

- Bajo peso: < 18.5
- Peso normal: 18.5 - 24.9
- Sobrepeso: 25 - 29.9
- Obesidad: ≥ 30

## Estructura del Proyecto

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/appparcialjuanlopez/
│   │   │   ├── data/
│   │   │   │   ├── BmiDatabase.kt
│   │   │   │   ├── BmiDao.kt
│   │   │   │   └── BmiRecord.kt
│   │   │   ├── ui/
│   │   │   │   ├── HomeScreen.kt
│   │   │   │   ├── DetailsScreen.kt
│   │   │   │   └── SettingsScreen.kt
│   │   │   ├── viewmodel/
│   │   │   │   └── BmiViewModel.kt
│   │   │   └── MainActivity.kt
│   │   └── res/
│   └── test/
└── build.gradle
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue primero para discutir los cambios que te gustaría hacer.

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Autor

Juan López

## Screenshot

![image](https://github.com/user-attachments/assets/9b68f952-dd9b-4ae9-97c3-3b9eb1ad2c92)

![image](https://github.com/user-attachments/assets/32044c6b-10e0-4a39-8562-4489def8dc16)

![image](https://github.com/user-attachments/assets/6278be0f-130e-42f2-8b57-de6a10337c62)

![image](https://github.com/user-attachments/assets/d66b90c9-5225-4984-b458-5e05afc816fa)

## Agradecimientos

- Material Design 3 por los componentes de UI
- Jetpack Compose por el framework de UI moderno
- Room Database por la persistencia de datos 
