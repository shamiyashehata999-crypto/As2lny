# تشغيل اسألني على سيرفر حقيقي

هذه النسخة جاهزة للنشر على Render باستخدام Docker وPersistent Disk لقاعدة SQLite.

## 1. إنشاء الخدمة
- ارفع مجلد المشروع إلى GitHub.
- في Render اختر New > Blueprint.
- اختر المستودع الذي يحتوي `render.yaml`.
- أدخل `OWNER_EMAIL` و`OWNER_PASSWORD` و`PUBLIC_APP_URL` و`AI_API_KEY` كقيم سرية.
- لا تضع JWT_SECRET داخل Git؛ Render يولده تلقائياً.

## 2. بعد النشر
تحقق من:
`https://YOUR-SERVICE.onrender.com/health`

يجب أن يرجع JSON يحتوي `ok: true`.

## 3. ربط Android
بعد معرفة رابط السيرفر النهائي، عدّل:
`public/config.js`
إلى:
`window.ASALNI_API_BASE = 'https://YOUR-SERVICE.onrender.com';`
ثم ابنِ APK جديد.

## 4. ملاحظة مهمة
SQLite هنا محفوظ على Persistent Disk. لا تحذف الـDisk عند إعادة النشر، وإلا ستفقد قاعدة البيانات.
