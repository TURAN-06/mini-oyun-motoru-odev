# AI Log - Phase 1

**AI'a ne sordunuz? (Prompt):** "GameObject.java kodundaki nesne yaratma sorununu Factory Method örüntüsü ile nasıl çözebilirim? Interface kullanarak daha profesyonel bir yapı kurmama yardımcı olur musun?"

**AI ne yanıtladı? (Özet):** AI, mevcut if-else yapısını silerek bir `IGameObject` arayüzü (interface) oluşturmamı ve her nesne türü için (`Player`, `Enemy`) ayrı sınıflar tanımlamamı önerdi. Nesne üretimini ise `GameObjectFactory` sınıfına devretmem gerektiğini belirtti.

**Siz ne uyguladınız ve neden?** AI'ın önerdiği Factory Method yapısını uyguladım. Çünkü bu sayede ana kodumun (Main) içine girmeden yeni nesne türleri ekleyebilirim. AI'ın önerdiği Interface mantığı, kodun tip güvenliğini (type safety) artırdı.
