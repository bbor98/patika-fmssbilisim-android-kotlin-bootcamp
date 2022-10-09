# CoroutineInfiniteLoop

## 1. CoroutineScope'u kapsayan bir sonsuz döngü yapın ve içinde sayaç yapın.
![Image1](https://user-images.githubusercontent.com/88214480/193443492-69dfed62-6ac5-4193-9e2e-6c54a9437c03.png)

## 2. Döngü kilitlenmeye sebep olacak mı?
Evet, uygulama bir süre sonra çöker.

![Image2](https://user-images.githubusercontent.com/88214480/193443496-bb5c78a6-ee19-499b-868b-5e6e86c21128.png)

## 3. Kilitlenmeye sebep olmadan aşağıdaki blok çalışır mı?
```kotlin
CoroutineScope(Dispatchers.IO).launch {
  val answer = doNetworkCall()
  withContext(Dispatchers.Main) {
    Log.v("PATIKA", answer)
  }
}
```
Sonsuz döngü main thread'i blokladığı için döngü sona erdirilmediği sürece `withContext(Dispatchers.Main)` bloğu içerisindeki kod çalışmaz ve resimde de görüldüğü üzere herhangi bir output elde edilmez.

![Image3](https://user-images.githubusercontent.com/88214480/193443498-97554ad4-e316-4f21-b34c-aa5871142620.png)
